<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link href="/css/style.css" rel="stylesheet">
</head>
<body>
  <div class="login-form">
    <form method="post" action="/login" id="loginForm">
      <h1 class="h3 mb-3 fw-normal text-center">Sign in</h1>
      <div class="form-floating mb-3">
        <input type="text" name="username" class="form-control" placeholder="Username">
        <label for="floatingInput">Username</label>
      </div>
      <div class="form-floating mb-3">
        <input type="password" name="password" class="form-control" placeholder="Password">
        <label for="floatingPassword">Password</label>
      </div>
      <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
      <p class="mt-3 mb-3 text-center">Don't have an account? <a href="/register">Register Now!</a></p>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2024 Techmaster.vn</p>
    </form>
  </div>
</body>
</html>
