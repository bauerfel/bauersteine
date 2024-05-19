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

    function createUrne() {
        var config = {
            method: "post",
            url: api_root + "/api/urne",
            headers: {
                Authorization: "Bearer " + $jwt_token,
                //"Content-Type": "application/json",
            },
            data: urne,
        };

        axios(config)
            .then(function (response) {
                alert("Urne created");
                getUrnen();
            })
            .catch(function (error) {
                alert("Could not create Urne");
                console.log(error);
            });
    }
</script>

    <h1 class="mt-3">Create Urne</h1>
    <form class="mb-5">
        <div class="row mb-3">
            <div class="col">
                <label class="form-label" for="description">Beschreibung</label>
                <input
                    bind:value={urne.beschreibung}
                    class="form-control"
                    id="description"
                    type="text"
                />
            </div>
        </div>
        <div class="row mb-3">
            <div class="col">
                <label class="form-label" for="description">Material</label>
                <input
                    bind:value={urne.material}
                    class="form-control"
                    id="description"
                    type="text"
                />
            </div>
        </div>
        <div class="row mb-3">
            <div class="col">
                <label class="form-label" for="earnings">Preis</label>
                <input
                    bind:value={urne.preis}
                    class="form-control"
                    id="earnings"
                    type="number"
                />
            </div>
        </div>
        <div class="row mb-3">
            <div class="col">
                <label class="form-label" for="earnings"
                    >Inhaltsmenge in Liter</label
                >
                <input
                    bind:value={urne.inhaltsmenge}
                    class="form-control"
                    id="earnings"
                    type="number"
                />
            </div>
        </div>
        <!-- <div class="row mb-3">
      <div class="col">
        <label class="form-label" for="type">Type</label>
        <select bind:value={job.jobType} class="form-select" id="type">
          <option value="OTHER">OTHER</option>
          <option value="TEST">TEST</option>
          <option value="IMPLEMENT">IMPLEMENT</option>
          <option value="REVIEW">REVIEW</option>
        </select>
      </div>
     
    </div> -->
        <button type="button" class="btn btn-primary" on:click={createUrne}
            >Submit</button
        >
    </form>

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
