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
</script>

<h1>Alle Urnen</h1>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Beschreibung</th>
            <th scope="col">Material</th>
            <th scope="col">Preis</th>
            <th scope="col">Inhaltsmenge</th>
            <th scope="col">State</th>
            <th scope="col">UrneId</th>
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
            </tr>
        {/each}
    </tbody>
</table>