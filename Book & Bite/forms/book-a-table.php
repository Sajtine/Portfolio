<?php

  include "conn.php";

  if(isset($_POST['submit'])){
    $number = $_POST['people'];

    ?>
    <script>
      alert("Hello User!" + $number);
    </script>

    <?php
  }


?>