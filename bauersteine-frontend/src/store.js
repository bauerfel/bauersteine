import { writable, derived } from "svelte/store";
import axios from 'axios';

// user 
export const user = writable({});
let sessionUser = sessionStorage.getItem("user");
if (sessionUser) {
    user.set(JSON.parse(sessionUser));
} else {
    // create the key "user" in the session storage if it doesn't exist yet
    sessionStorage.setItem("user", {});
}
// update the user in the sessionStorage on changes
user.subscribe(user => sessionStorage.setItem("user", JSON.stringify(user)));


// isAuthenticated: we assume that users are authenticated if the property "user.name" exists
export const isAuthenticated = derived(
    user,
    $user => $user && $user.name
);

// jwt_token and myUserId
export const jwt_token = writable("");
export const myUserId = writable(null);
export const myUserEmail = writable(null);
let sessionToken = sessionStorage.getItem("jwt_token");
if (sessionToken) {
    jwt_token.set(sessionToken);
} else {
    // create the key "jwt_token" in the session storage if it doesn't exist yet
    sessionStorage.setItem("jwt_token", "");
}


// update the jwt_token and myUserId in the sessionStorage on changes
jwt_token.subscribe(jwt_token => {
    sessionStorage.setItem("jwt_token", jwt_token);
    if (jwt_token === "") {
        myUserId.set(null)
    } else {
        var config = {
            method: "get",
            url: window.location.origin + "/api/me/user",
            headers: { Authorization: "Bearer " + jwt_token },
        };
        axios(config)
            .then(function (response) {
                myUserId.set(response.data.id);
            })
            .catch(function (error) {
                alert("Could not get a User associated to current User");
                console.log(error);
            });
    }
});

// update the jwt_token and myUserEmail in the sessionStorage on changes
jwt_token.subscribe(jwt_token => {
    sessionStorage.setItem("jwt_token", jwt_token);
    if (jwt_token === "") {
        myUserEmail.set(null)
    } else {
        var config = {
            method: "get",
            url: window.location.origin + "/api/me/user",
            headers: { Authorization: "Bearer " + jwt_token },
        };
        axios(config)
            .then(function (response) {
                myUserEmail.set(response.data.email);
            })
            .catch(function (error) {
                alert("Could not get a User associated to current User");
                console.log(error);
            });
    }
});


// import { writable, derived } from "svelte/store";

// // user 
// export const user = writable({});
// let sessionUser = sessionStorage.getItem("user");
// if (sessionUser) {
//     user.set(JSON.parse(sessionUser));
// } else {
//     // create the key "user" in the session storage if it doesn't exist yet
//     sessionStorage.setItem("user", {});
// }
// // update the user in the sessionStorage on changes
// user.subscribe(user => sessionStorage.setItem("user", JSON.stringify(user)));


// // isAuthenticated: we assume that users are authenticated if the property "user.name" exists
// export const isAuthenticated = derived(
//     user,
//     $user => $user && $user.name
// );

// // jwt_token and myFreelancerId
// export const jwt_token = writable("");
// export const myFreelancerId = writable(null);
// let sessionToken = sessionStorage.getItem("jwt_token");
// if (sessionToken) {
//     jwt_token.set(sessionToken);
// } else {
//     // create the key "jwt_token" in the session storage if it doesn't exist yet
//     sessionStorage.setItem("jwt_token", "");
// }
