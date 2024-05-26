<script>
    import { isAuthenticated } from "../store";
    import auth from "../auth.service";

    let username = "";
    let password = "";
    let loginForm;

    function loginWithUsernameAndPassword() {
        // form validation with bootstrap: see https://getbootstrap.com/docs/5.3/forms/validation/
        if (loginForm.checkValidity()) {
            console.log("login");
            auth.login(username, password);
        }
        loginForm.classList.add("was-validated");
    }
</script>

{#if $isAuthenticated}
    <h1>Willkommen zu Bauersteine Graburnen</h1>

    <p>
        Wir freuen uns, Sie auf unserer Homepage begrüssen zu dürfen. Hier finden
        Sie alle Informationen und Dienstleistungen, die wir Ihnen anbieten.
        Unsere Mission ist es, Ihnen die besten Produkte und den besten Service
        zu bieten, um Ihre Bedürfnisse und Wünsche zu erfüllen.
    </p>
    <p>
        Stöbern Sie durch unsere Kategorien, entdecken Sie unsere neuesten
        Angebote und lassen Sie sich von unseren exklusiven Produkten
        inspirieren. Unser engagiertes Team steht Ihnen jederzeit zur Verfügung,
        um Ihre Fragen zu beantworten und Ihnen bei Ihren Anliegen zu helfen.
    </p>
    <p>
        Wir wünschen Ihnen viel Freude beim Erkunden unserer Webseite und
        hoffen, dass Sie alles finden, was Sie suchen. Zögern Sie nicht, uns zu
        kontaktieren, wenn Sie Unterstützung benötigen.
    </p>

    <!-- Beispiel für die Verwendung von Bildern im Ordner 'static/images' -->
{:else}
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">Login</div>
                    <div class="card-body">
                        <form
                            on:submit|preventDefault={loginWithUsernameAndPassword}
                            bind:this={loginForm}
                            class="needs-validation"
                            novalidate
                        >
                            <div class="mb-3">
                                <label for="username" class="form-label"
                                    >Email</label
                                >
                                <input
                                    bind:value={username}
                                    type="text"
                                    class="form-control"
                                    id="username"
                                    name="username"
                                    required
                                />
                                <div class="invalid-feedback">
                                    Please provide your username.
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label"
                                    >Password</label
                                >
                                <input
                                    bind:value={password}
                                    type="password"
                                    class="form-control"
                                    id="password"
                                    name="password"
                                    required
                                />
                                <div class="invalid-feedback">
                                    Please provide your password.
                                </div>
                            </div>
                            <div class="row align-items-end">
                                <div class="col">
                                    <button
                                        type="submit"
                                        class="btn btn-primary">Log in</button
                                    >
                                </div>
                                <div class="col-auto">
                                    <a href="/signup">Sign up</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
{/if}
