<script>
import axios from "axios";
import { page } from "$app/stores";
import { onMount } from "svelte";
import { jwt_token } from "../../store";

const api_root = $page.url.origin;

let urnen = [];
let urne = {
    beschreibung: "",
    material: "",
    preis: 0,
    inhaltsmenge: 0,
};

onMount(() => {
    getUrnen();
});

function getUrnen() {
    var config = {
        method: "get",
        url: api_root + "/api/urne",
        headers: {},
        headers: { Authorization: "Bearer " + $jwt_token },
    };

    axios(config)
        .then(function (response) {
            urnen = response.data;
        })
        .catch(function (error) {
            alert("Could not get Urnen");
            console.log(error);
        });
}

async function assignToMyOrder(urneId) {
    try {
        const config = {
            headers: { Authorization: "Bearer " + $jwt_token },
        };

        // Get user email from JWT
        const jwt = parseJwt($jwt_token);
        const email = jwt.email;

        // Check if an order with the state ASSIGNED exists for the user
        let response = await axios.get(
            `${api_root}/api/order/byEmailAndStatus`,
            {
                params: {
                    email: email,
                    status: "ASSIGNED",
                },
                ...config,
            }
        );

        let orders = response.data;

        if (orders.length > 0) {
            // Update the existing order
            let order = orders[0];
            order.urneIds.push(urneId);

            response = await axios.post(
                `${api_root}/api/service/${order.id}/addUrne/${urneId}`,
                {},
                config
            );
        } else {
            // Create a new order
            const orderCreateDTO = {
                urneIds: [urneId],
            };

            response = await axios.post(
                `${api_root}/api/order`,
                orderCreateDTO,
                config
            );
        }

        alert("Urne successfully assigned to the order");
    } catch (error) {
        alert("Failed to assign Urne to the order");
        console.error(error);
    }
}

function parseJwt(token) {
    try {
        const base64Url = token.split(".")[1];
        const base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
        const jsonPayload = decodeURIComponent(
            atob(base64)
                .split("")
                .map(function (c) {
                    return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
                })
                .join("")
        );

        return JSON.parse(jsonPayload);
    } catch (e) {
        return null;
    }
}
</script>

<h1>Alle Urnen</h1>

<div class="row">
    {#each urnen as urne}
    <div class="col-md-4 mb-3">
        <div class="card">
            <img src="/images/Urne.jpeg" class="card-img-top" alt="Urne Image">
            <div class="card-body">
                <h5 class="card-title">{urne.beschreibung}</h5>
                <p class="card-text">Material: {urne.material}</p>
                <p class="card-text">Preis: {urne.preis} €</p>
                <p class="card-text">Inhaltsmenge: {urne.inhaltsmenge} Liter</p>
                <!-- <p class="card-text">State: {urne.state}</p>
                <p class="card-text">ID: {urne.id}</p> -->
                {#if urne.state === "ASSIGNED" || urne.state === "SOLD" || urne.state === "DELIVERED"}
                <span class="badge bg-secondary">Ausverkauft</span>
                {:else}
                <button type="button" class="btn btn-secondary" on:click={() => assignToMyOrder(urne.id)}>
                    Zu Bestellung hinzufügen
                </button>
                {/if}
            </div>
        </div>
    </div>
    {/each}
</div>
<!-- <table class="table">
    <thead>
        <tr>
            <th scope="col">Beschreibung</th>
            <th scope="col">Material</th>
            <th scope="col">Preis</th>
            <th scope="col">Inhaltsmenge</th>
            <th scope="col">State</th>
            <th scope="col">UrneId</th>
            <th scope="col">Aktion</th>
        </tr>
    </thead>
    <tbody>
        {#each urnen as urne}
            <tr>
                <td>{urne.beschreibung}</td>
                <td>{urne.material}</td>
                <td>{urne.preis}</td>
                <td>{urne.inhaltsmenge}</td>
                <td>{urne.state}</td>
                <td>{urne.id}</td>
                <td>
                    {#if urne.state === "ASSIGNED" || urne.state === "SOLD" || urne.state === "DELIVERED"}
                    <span class="badge bg-secondary">Ausverkauft</span> 
                    {:else}
                    <button type="button" class="btn btn-secondary" on:click={() => assignToMyOrder(urne.id)}>
                        Zu Bestellung hinzufügen
                    </button>
                    {/if}
                </td>
            </tr>
        {/each}
    </tbody>
</table> -->