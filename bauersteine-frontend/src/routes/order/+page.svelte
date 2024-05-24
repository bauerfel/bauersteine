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

    // function createorder() {
    //     var config = {
    //         method: "post",
    //         url: api_root + "/api/order",
    //         headers: {
    //             Authorization: "Bearer " + $jwt_token,
    //             //"Content-Type": "application/json",
    //         },
    //         data: order,
    //     };

    //     axios(config)
    //         .then(function (response) {
    //             alert("order created");
    //             getorders();
    //         })
    //         .catch(function (error) {
    //             alert("Could not create order");
    //             console.log(error);
    //         });
    // }
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
                    <td>{order.urneIds}</td>
                    <td>
                        {#if order.state === "ASSIGNED"}
                            <button on:click={() => payOrder(order.id)}
                                >Bezahlen</button
                            >
                        {/if}
                    </td>
                </tr>
            {/if}
        {/each}
    </tbody>
</table>
