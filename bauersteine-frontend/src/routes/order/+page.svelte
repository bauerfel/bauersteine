<script>
    import axios from "axios";
    import { page } from "$app/stores";
    import { onMount } from "svelte";
    import { jwt_token } from "../../store";
    const api_root = $page.url.origin;

    let orders = [];
    let order = {
        id: "",
        urneIds: [],
        state: "",
    };

    onMount(() => {
        getorders();
    });

    function getorders() {
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

    function createorder() {
        var config = {
            method: "post",
            url: api_root + "/api/order",
            headers: {
                Authorization: "Bearer " + $jwt_token,
                //"Content-Type": "application/json",
            },
            data: order,
        };

        axios(config)
            .then(function (response) {
                alert("order created");
                getorders();
            })
            .catch(function (error) {
                alert("Could not create order");
                console.log(error);
            });
    }
</script>

<h1>Deine Bestellungen</h1>

<h1>Alle Orders</h1>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Order ID</th>
            <th scope="col">State</th>
            <th scope="col">UrneIds</th>
        </tr>
    </thead>
    <tbody>
        {#each orders as order}
            <tr>
                <td>{order.id}</td>
                <td>{order.state}</td>
                <td>{order.urneIds}</td>
            </tr>
        {/each}
    </tbody>
</table>
