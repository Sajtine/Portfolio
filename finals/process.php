<?php

  // Booked Table

  include "conn.php";

  session_start();

  
  if(isset($_POST['book'])){

    if(empty($_SESSION)){
      ?>
      <script>
        alert("Please Login");
        window.location.href="stylish-login-page-html-website-template/login.html";
      </script>
      <?php
    }else{

      $Cemail = $_SESSION['email'];

      $name = $_POST['name'];
      $email = $_POST['email'];
      $num = $_POST['phone'];
      $date = $_POST['date'];
      $time = $_POST['time'];
      $number = $_POST['people'];
      $table = $_POST['selected'];

      if($Cemail != $email){
        ?>
        <script>
          alert("Use the Email you used in the Log in!");
          window.location.href="main.php";
        </script>

        <?php
      }else{

        $insert = mysqli_query($conn, "INSERT INTO bite VALUES ('0','$name','$email','$num','$date','$time','$number','$table')");

        ?>
  
        <script>
          alert("Booked Successfully!");
          window.location.href="main.php";
        </script>
  
        <?php
      }
      
     
    }
  }


  // Log In

  if(isset($_POST['login'])){
    $email = $_POST['email'];
    $pass = $_POST['password'];

    $check = mysqli_query($conn, "SELECT * FROM user WHERE email='$email' AND password='$pass'"); 

    $num_check = mysqli_num_rows($check);

    if($num_check <= 0){
      ?>
      <script>
          alert("Wrong email and Password");
          window.location.href="stylish-login-page-html-website-template/login.html";
      </script>
      <?php
  }else{
      $_SESSION['email'] = $email;
      ?>
      <script>
          alert("Login Successfully");
          window.location.href="main.php";
      </script>
      <?php
  }

  }


  // Sign In

  if(isset($_POST['signup'])){
    $fn = $_POST['fn'];
    $email = $_POST['email'];
    $pass = $_POST['pass'];

    $check = mysqli_query($conn, "SELECT email FROM user WHERE email='$email'");
    $checkEmail = mysqli_num_rows($check);

      if($checkEmail <= 0){
        $insert = mysqli_query($conn, "INSERT INTO user VALUES('0','$fn','$email','$pass')");

        ?>
        <script>
          alert("Sign Up Successfully!");
          window.location.href="stylish-login-page-html-website-template/login.html";
        </script>

        <?php

      }else{
        ?>
        <script>
          alert("Email in use!!");
          window.location.href="stylish-login-page-html-website-template/signup.html";
        </script>

        <?php
      }
    
  }

  // Profile

  $defaultName = "Kiara Mona";
  $defaultEmail = "123@gmail.com";
  $dPass = "123";
 

  if(!empty($_SESSION)){

    $e = $_SESSION['email'];

    $getdetails = mysqli_query($conn, "SELECT * FROM user WHERE email = '$e'");
    while($row = mysqli_fetch_object($getdetails)){
      $defaultName = $row -> fullname;
      $defaultEmail = $row -> email;
      $dPass = $row -> password;

    }

  }


  // Booked Info

  $defaultTable = "0";
  $defaultNumber = "***********";
  $defaultDate = "0000-00-00";
  $defaultTime = "00";
  $defaultPeople = "0";

  if(!empty($_SESSION)){
    $getdetails = mysqli_query($conn, "SELECT * FROM bite WHERE email = '$e'");
    while($row = mysqli_fetch_object($getdetails)){
      $defaultTable = $row -> tables;
      $defaultNumber = $row -> number;
      $defaultDate = $row -> date;
      $defaultTime = $row -> time;
      $defaultPeople = $row -> people;

    }
  }


  // Modify Profile

  $dPhone = "*********";

  if(!empty($_SESSION)){

    $e = $_SESSION['email'];

    $getdetails = mysqli_query($conn, "SELECT * FROM bite WHERE email = '$e'");
    while($row = mysqli_fetch_object($getdetails)){
      $dPhone = $row -> number;

    }

  }

    
  if(isset($_POST['info'])){
  
      // Assuming $conn is your database connection
      
      // Escape user inputs for security (Preventing SQL Injection)
      $fn2 = mysqli_real_escape_string($conn, $_POST['fn2']);
      $email2 = mysqli_real_escape_string($conn, $_POST['email2']);
      $num2 = mysqli_real_escape_string($conn, $_POST['num2']);
      $pass2 = mysqli_real_escape_string($conn, $_POST['pass2']);
      $e = $_SESSION['email'];
  
      // Perform update queries
      $update = mysqli_query($conn, "UPDATE user SET fullname='$fn2', email='$email2', password='$pass2' WHERE email='$e'");
      $update2 = mysqli_query($conn, "UPDATE bite SET name='$fn2', email='$email2', number='$num2' WHERE email='$e'");
  
      // Check if updates were successful
      if($update && $update2){

        $e = $email2;

        $_SESSION['email'] = $email2;

        
          ?>
          <script>
              alert("Update successful!");
              window.location.href = "main.php";
          </script>
          <?php
      }else{
          ?>
          <script>
              alert("Update unsuccessful!");
              window.location.href = "main.php"; // Redirect to appropriate page
          </script>
          <?php
      }
  }


  // Contact

  if(isset($_POST['con'])){

    $Cname = $_POST['Cname'];
    $Cemail = $_POST['Cemail'];
    $Csubject = $_POST['Csubject'];
    $Cmessage = $_POST['Cmessage'];

    $Cinsert = mysqli_query($conn, "INSERT INTO contact (id, name, email, subject, message) VALUES ('0','$Cname','$Cemail','$Csubject', '$Cmessage')");


    if($Cinsert == true){
      ?>
      <script>
        alert("Message Sent!");
        window.location.href="main.php";
      </script>

      <?php
    }else{
      ?>

      <script>
        alert("Message was not sent!");
        window.location.href="main.php";
      </script>

      <?php
    }


  }

  $sql = "SELECT availability FROM desk";
  $result = mysqli_query($conn, $sql);
  
  // Check if the query was successful
  if ($result) {
      // Fetch all data from the result set into an array
      $availability_data = mysqli_fetch_all($result, MYSQLI_ASSOC);
  
      // Free result set
      mysqli_free_result($result);
  } else {
      echo "Error: " . $sql . "<br>" . mysqli_error($conn);
  }

  if (!empty($availability_data)) {
    foreach ($availability_data as $index => $data) {
        ${"availability_$index"} = $data['availability'];
    }
  }
    
  // Dashboard
  if(isset($_POST['updStat'])){

    $table_id = $_POST["table_id"];
    $new_status = $_POST["status"];

    $sql = "UPDATE desk SET availability = '$new_status' WHERE id = $table_id";
    mysqli_query($conn, $sql);

    if($sql == true){
      ?>
      <script>
        alert("Updated");
        window.location.href="dashboard.php";
      </script>

      <?php
    }

  }

?>