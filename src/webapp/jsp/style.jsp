<style>
    .footer-basic {
        padding: 40px 0;
        background-color: #ffffff;
        color: #4b4c4d;
    }

    .footer-basic ul {
        padding: 0;
        list-style: none;
        text-align: center;
        font-size: 18px;
        line-height: 1.6;
        margin-bottom: 0;
    }

    .footer-basic li {
        padding: 0 10px;
    }

    .footer-basic ul a {
        color: inherit;
        text-decoration: none;
        opacity: 0.8;
    }

    .footer-basic ul a:hover {
        opacity: 1;
    }

    .footer-basic .social {
        text-align: center;
        padding-bottom: 25px;
    }

    .footer-basic .social > a {
        font-size: 24px;
        width: 40px;
        height: 40px;
        line-height: 40px;
        display: inline-block;
        text-align: center;
        border-radius: 50%;
        border: 1px solid #ccc;
        margin: 0 8px;
        color: inherit;
        opacity: 0.75;
    }

    .footer-basic .social > a:hover {
        opacity: 0.9;
    }

    .footer-basic .copyright {
        margin-top: 15px;
        text-align: center;
        font-size: 13px;
        color: #aaa;
        margin-bottom: 0;
    }

    .navigation-clean-button {
        background: #fff;
        padding-top: .75rem;
        padding-bottom: .75rem;
        color: #333;
        border-radius: 0;
        box-shadow: none;
        border: none;
        margin-bottom: 0;
    }

    @media (min-width: 768px) {
        .navigation-clean-button {
            padding-top: 1rem;
            padding-bottom: 1rem;
        }
    }

    .navigation-clean-button .navbar-brand {
        font-weight: bold;
        color: inherit;
    }

    .navigation-clean-button .navbar-brand:hover {
        color: #222;
    }

    .navigation-clean-button .navbar-toggler {
        border-color: #ddd;
    }

    .navigation-clean-button .navbar-toggler:hover,
    .navigation-clean-button .navbar-toggler:focus {
        background: none;
    }

    .navigation-clean-button .navbar-toggler {
        color: #888;
    }

    .navigation-clean-button .navbar-collapse,
    .navigation-clean-button .form-inline {
        border-top-color: #ddd;
    }

    .navigation-clean-button .navbar-nav a.active,
    .navigation-clean-button .navbar-nav > .show > a {
        background: none;
        box-shadow: none;
    }

    .navigation-clean-button.navbar-light .navbar-nav a.active,
    .navigation-clean-button.navbar-light .navbar-nav a.active:focus,
    .navigation-clean-button.navbar-light .navbar-nav a.active:hover {
        color: #8f8f8f;
        box-shadow: none;
        background: none;
        pointer-events: none;
    }

    .navigation-clean-button.navbar .navbar-nav .nav-link {
        padding-left: 18px;
        padding-right: 18px;
    }

    .navigation-clean-button.navbar-light .navbar-nav .nav-link {
        color: #465765;
    }

    .navigation-clean-button.navbar-light .navbar-nav .nav-link:focus,
    .navigation-clean-button.navbar-light .navbar-nav .nav-link:hover {
        color: #37434d !important;
        background-color: transparent;
    }

    .navigation-clean-button .navbar-nav > li > .dropdown-menu {
        margin-top: -5px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, .1);
        background-color: #fff;
        border-radius: 2px;
    }

    .navigation-clean-button .dropdown-menu .dropdown-item:focus,
    .navigation-clean-button .dropdown-menu .dropdown-item {
        line-height: 2;
        font-size: 14px;
        color: #37434d;
    }

    .navigation-clean-button .dropdown-menu .dropdown-item:focus,
    .navigation-clean-button .dropdown-menu .dropdown-item:hover {
        background: #eee;
        color: inherit;
    }

    .navigation-clean-button .actions .login {
        margin-right: 1rem;
        text-decoration: none;
        color: #465765;
    }

    .navigation-clean-button .navbar-text .action-button,
    .navigation-clean-button .navbar-text .action-button:active,
    .navigation-clean-button .navbar-text .action-button:hover {
        background: #56c6c6;
        border-radius: 20px;
        font-size: inherit;
        color: #fff;
        box-shadow: none;
        border: none;
        text-shadow: none;
        padding: .5rem 1rem;
        transition: background-color 0.25s;
        font-size: inherit;
    }

    .register-photo {
        background: #f1f7fc;
        padding: 80px 0;
    }

    .register-photo .image-holder {
        display: table-cell;
        width: auto;
        background: url(../../assets/img/meeting.jpg);
        background-size: cover;
    }

    .register-photo .form-container {
        display: table;
        max-width: 900px;
        width: 90%;
        margin: 0 auto;
        box-shadow: 1px 1px 5px rgba(0, 0, 0, 0.1);
    }

    .register-photo form {
        display: table-cell;
        width: 400px;
        background-color: #ffffff;
        padding: 40px 60px;
        color: #505e6c;
    }

    @media (max-width: 991px) {
        .register-photo form {
            padding: 40px;
        }
    }

    .register-photo form h2 {
        font-size: 24px;
        line-height: 1.5;
        margin-bottom: 30px;
    }

    .register-photo form .form-control {
        background: #f7f9fc;
        border: none;
        border-bottom: 1px solid #dfe7f1;
        border-radius: 0;
        box-shadow: none;
        outline: none;
        color: inherit;
        text-indent: 6px;
        height: 40px;
    }

    .register-photo form .form-check {
        font-size: 13px;
        line-height: 20px;
    }

    .register-photo form .btn-primary {
        background: #f4476b;
        border: none;
        border-radius: 4px;
        padding: 11px;
        box-shadow: none;
        margin-top: 35px;
        text-shadow: none;
        outline: none !important;
    }

    .register-photo form .btn-primary:hover, .register-photo form .btn-primary:active {
        background: #eb3b60;
    }

    .register-photo form .btn-primary:active {
        transform: translateY(1px);
    }

    .register-photo form .already {
        display: block;
        text-align: center;
        font-size: 12px;
        color: #6f7a85;
        opacity: 0.9;
        text-decoration: none;
    }

    .card-img-top {
        object-fit: cover;
        height: 150px;
    }

    .navigation-clean-button .navbar-text .action-button:hover {
        background: #66d7d7;
    }

    .jumbotron {
        background-image: url(https://images.unsplash.com/photo-1520340356584-f9917d1eea6f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1489&q=80);
        background-size: cover;
        background-position: center;
    }

    .jumbo-inner-box {
        background-color: rgba(55, 155, 155, 0.1);
        padding: 40px 6vw;
        color: #fff;
        border-radius: 15px;
        backdrop-filter: blur(5px);
        filter: drop-shadow(3px 9px 9px black);
        box-shadow: 3px 9px 9px rgba(0,0,0,0.1);
    }
    .jumbo-inner-box::before {
        content: " ";
        overflow: hidden;
        display: block;
        position: absolute;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        border-radius: 15px;
        border-top-left-radius: 250px 100px;
        background: -webkit-linear-gradient(top left, rgba(255,255,255,0.7) 0%,rgba(255,255,255,0.05) 20%);
    }

    .jumbo-inner-box p {
        margin-bottom: 3rem;
    }

    .card-body {
        padding: 0;
    }

    .card-body .d-block,
    .card-body .d-flex {
        padding: 0 10px;
    }

    .card-img-top {
        margin-bottom: 15px;
    }

    .card {
        min-width: 100%;
    }

    input.w-50 {
        min-width: 60px;
    }

    .custom-switch .custom-control-label::after {
        border-color: #1579f6;
    }

    .custom-control-label::before {
        border-color: #1579f6;
    }

    .toast {
        /*opacity: 1;*/
        position: fixed;
        bottom: 20px;
        right: 20px;
    }

    .card.premium-ad-card {
        background-color: azure;
        box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.2);
    }

    .observed-btn {
        position: relative;
        top: -165px;
    }

    .tooltiptext {
        position: absolute;
        display: block;
        opacity: 0;
        left: 0px;
        top: -9px;
        padding: 6px;
        line-height: 100%;
        background-color: var(--light);
        border-radius: 5px;
        transition: 300ms;
        box-shadow: 3px 3px 5px 0px rgba(0,0,0,.6);
    }

    .tooltiptext::after {
        content: " ";
        position: absolute;
        top: 50%;
        right: 99%;
        margin-top: -10px;
        border-width: 11px;
        border-style: solid;
        border-color: transparent var(--light) transparent transparent;
    }

    .observed-btn:hover
    .tooltiptext {
        left: 33px;
        opacity: .8;
    }

</style>
