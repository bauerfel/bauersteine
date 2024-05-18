<script>
    import axios from "axios";
    import { page} from "$app/stores";
    import { onMount } from "svelte";
    import { jwt_token} from "../../store";
    const api_root = $page.url.origin;


    let orders = [];
    let order = {
        beschreibung: "",
        material: "",
        preis: 0,
        inhaltsmenge: 0,
    };

    onMount(() => {
        getorders();
    });

    function getorders() {
        var config = {
            method: "get",
            url: api_root + "/api/order",
            headers: {},
            headers: {Authorization: "Bearer "+$jwt_token},
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
            headers: { Authorization: "Bearer "+$jwt_token,
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
