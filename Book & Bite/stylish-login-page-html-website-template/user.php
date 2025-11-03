<?php

  include "../conn.php";


  // For Log In

  if(isset($_POST['login'])){
    $email = $_POST['email'];
    $pass = $_POST['password'];

    $check = mysqli_query($conn, "SELECT * FROM user WHERE email='$email' AND password='$pass'");
    $num_check = mysqli_num_rows($check);

    if($num_check <= 0){
      ?>
      <script>
          alert("Wrong email and Password");
          window.location.href="login.php";
      </script>
      <?php
  }else{
      $_SESSION['email'] = $email;
      ?>
      <script>
          alert("Login Successfully");
          window.location.href="../index.html";
      </script>
      <?php
  }

  }


?>