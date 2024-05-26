<script>
    import axios from "axios";
    import { page } from "$app/stores";
    import { onMount } from "svelte";
    import { jwt_token, user, myUserId, myUserEmail } from "../../store";
    const api_root = $page.url.origin;

    let orders = [];
    let order = {
        id: "",
        urneIds: [],
        state: "",
    };

    onMount(() => {
        getOrders();
    });

    function getOrders() {
        var config = {
            method: "get",
            url: api_root + "/api/order",
            headers: {},
            headers: { Authorization: "Bearer " + $jwt_token },
        };

        axios(config)
            .then(function (response) {
                orders = response.data;
            })
            .catch(function (error) {
                alert("Could not get orders");
                console.log(error);
            });
    }

    function payOrder(orderId) {
        var config = {
            method: "post",
            url: api_root + `/api/service/${orderId}/pay`,
            headers: {
                Authorization: "Bearer " + $jwt_token,
            },
        };

        axios(config)
            .then(function (response) {
                alert("Order paid");
                getOrders(); // Aktualisiere die Bestellungsliste nach dem Bezahlen
            })
            .catch(function (error) {
                alert("Could not pay order");
                console.log(error);
            });
    }
    function removeUrneFromOrder(orderId, urneId) {
        var config = {
            method: "delete",
            url: api_root + `/api/service/${orderId}/removeUrne/${urneId}`,
            headers: {
                Authorization: "Bearer " + $jwt_token,
            },
        };
        axios(config)
            .then(function (response) {
                alert("Urne removed from order");
                getOrders(); // Aktualisiere die Bestellungsliste nach dem Entfernen
            })
            .catch(function (error) {
                alert("Could not remove Urne from order");
                console.log(error);
            });
    }
</script>

<h1>Deine Bestellungen</h1>

<table class="table">
    <thead>
        <tr>
            <th scope="col">Bestellungnummer</th>
            <th scope="col">State</th>
            <th scope="col">UrneIds</th>
            <th scope="col">Bezahlen</th>
        </tr>
    </thead>
    <tbody>
        {#each orders as order}
            {#if order.userEmail === $myUserEmail}
                <tr>
                    <td>{order.id}</td>
                    <td>{order.state}</td>
                    <td>
                        {#each order.urneIds as urneId}
                            <div class="card mb-3" style="max-width: 540px;">
                                <div class="row g-0">
                                    <div class="col-md-4">
                                        <img
                                            src="/images/Urne.jpeg"
                                            class="img-fluid rounded-start"
                                            alt="Urne Image"
                                        />
                                    </div>
                                    <div class="col-md-8">
                                        <div class="card-body">
                                            <h5 class="card-title">
                                                Urne ID: {urneId}
                                            </h5>
                                            
                                            <p class="card-text">
                                                
                                            </p>
                                            {#if order.state === "ASSIGNED"}
                                                <button
                                                    class="btn btn-danger"
                                                    on:click={() =>
                                                        removeUrneFromOrder(
                                                            order.id,
                                                            urneId,
                                                        )}>Entfernen</button
                                                >
                                            {/if}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        {/each}
                    </td>
                    <td>
                        {#if order.state === "ASSIGNED"}
                            <button
                                type="button"
                                class="btn btn-secondary"
                                on:click={() => payOrder(order.id)}
                                >Bezahlen</button
                            >
                        {/if}
                    </td>
                </tr>
            {/if}
        {/each}
    </tbody>
</table>
