<?php

  include "process.php";

?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Restaurant Table Status Dashboard</title>
    <link rel="stylesheet" href="dashboard.css" />
  </head>
  <body>
    <div class="dashboard">
      <a href="#" class="bookings-link">View Bookings</a>
      <div class="content">
        <h1 style="color: antiquewhite">Restaurant Table Status</h1>
        <div class="tables">
          <div class="tables-for-two" style="margin-left: 30px;">
            <h2>Tables for Two</h2>

            <div class="table" data-table-id="1">
              <h3>Table 1</h3>
              <p>Status: <span class="status available"><?php echo $availability_0; ?></span></p>
              <form action="process.php" method="post">
                <input type="hidden" name="table_id" value="1" />
                <label for="status">Change Stat:</label>
                <select name="status" id="status">
                  <option value="available">Available</option>
                  <option value="occupied">Occupied</option>
                  <!-- Add more status options as needed -->
                </select>
                <button type="submit" name="updStat">Update Stat</button>
              </form>
            </div>

            <div class="table" data-table-id="2">
              <h3>Table 2</h3>
              <p>Status: <span class="status available"><?php echo $availability_1; ?></span></p>
              <form action="process.php" method="post">
                <input type="hidden" name="table_id" value="2" />
                <label for="status">Change Stat:</label>
                <select name="status" id="status">
                  <option value="available">Available</option>
                  <option value="occupied">Occupied</option>
                  <!-- Add more status options as needed -->
                </select>
                <button type="submit" name="updStat">Update Stat</button>
              </form>
            </div>

            <div class="table" data-table-id="3">
              <h3>Table 3</h3>
              <p>Status: <span class="status available"><?php echo $availability_2; ?></span></p>
              <form action="process.php" method="post">
                <input type="hidden" name="table_id" value="3" />
                <label for="status">Change Stat:</label>
                <select name="status" id="status">
                  <option value="available">Available</option>
                  <option value="occupied">Occupied</option>
                  <!-- Add more status options as needed -->
                </select>
                <button type="submit" name="updStat">Update Stat</button>
              </form>
            </div>

            <div class="table" data-table-id="4">
              <h3>Table 4</h3>
              <p>Status: <span class="status available"><?php echo $availability_3; ?></span></p>
              <form action="process.php" method="post">
                <input type="hidden" name="table_id" value="4" />
                <label for="status">Change Stat:</label>
                <select name="status" id="status">
                  <option value="available">Available</option>
                  <option value="occupied">Occupied</option>
                  <!-- Add more status options as needed -->
                </select>
                <button type="submit" name="updStat">Update Stat</button>
              </form>
            </div>

            <div class="table" data-table-id="5">
              <h3>Table 5</h3>
              <p>Status: <span class="status available"><?php echo $availability_4; ?></span></p>
              <form action="process.php" method="post">
                <input type="hidden" name="table_id" value="5"/>
                <label for="status">Change Stat:</label>
                <select name="status" id="status">
                  <option value="available">Available</option>
                  <option value="occupied">Occupied</option>
                  <!-- Add more status options as needed -->
                </select>
                <button type="submit" name="updStat">Update Stat</button>
              </form>
            </div>

          </div>

          <div class="tables-for-four" style="margin-right: 30px;">

            <h2>Tables for Four</h2>

            <div class="table" data-table-id="5">
              <h3>Table 6</h3>
              <p>Status: <span class="status available"><?php echo $availability_5; ?></span></p>
              <form action="process.php" method="post">
                <input type="hidden" name="table_id" value="6"/>
                <label for="status">Change Stat:</label>
                <select name="status" id="status">
                  <option value="available">Available</option>
                  <option value="occupied">Occupied</option>
                  <!-- Add more status options as needed -->
                </select>
                <button type="submit" name="updStat">Update Stat</button>
              </form>
            </div>

            <div class="table" data-table-id="5">
              <h3>Table 7</h3>
              <p>Status: <span class="status available"><?php echo $availability_6; ?></span></p>
              <form action="process.php" method="post">
                <input type="hidden" name="table_id" value="7"/>
                <label for="status">Change Stat:</label>
                <select name="status" id="status">
                  <option value="available">Available</option>
                  <option value="occupied">Occupied</option>
                  <!-- Add more status options as needed -->
                </select>
                <button type="submit" name="updStat">Update Stat</button>
              </form>
            </div>

            <div class="table" data-table-id="5">
              <h3>Table 8</h3>
              <p>Status: <span class="status available"><?php echo $availability_7; ?></span></p>
              <form action="process.php" method="post">
                <input type="hidden" name="table_id" value="8"/>
                <label for="status">Change Stat:</label>
                <select name="status" id="status">
                  <option value="available">Available</option>
                  <option value="occupied">Occupied</option>
                  <!-- Add more status options as needed -->
                </select>
                <button type="submit" name="updStat">Update Stat</button>
              </form>
            </div>

            <div class="table" data-table-id="5">
              <h3>Table 9</h3>
              <p>Status: <span class="status available"><?php echo $availability_8; ?></span></p>
              <form action="process.php" method="post">
                <input type="hidden" name="table_id" value="9"/>
                <label for="status">Change Stat:</label>
                <select name="status" id="status">
                  <option value="available">Available</option>
                  <option value="occupied">Occupied</option>
                  <!-- Add more status options as needed -->
                </select>
                <button type="submit" name="updStat">Update Stat</button>
              </form>
            </div>

            <div class="table" data-table-id="5">
              <h3>Table 10</h3>
              <p>Status: <span class="status available"><?php echo $availability_9; ?></span></p>
              <form action="process.php" method="post">
                <input type="hidden" name="table_id" value="10"/>
                <label for="status">Change Stat:</label>
                <select name="status" id="status">
                  <option value="available">Available</option>
                  <option value="occupied">Occupied</option>
                  <!-- Add more status options as needed -->
                </select>
                <button type="submit" name="updStat">Update Stat</button>
              </form>
            </div>

          </div>
        </div>
      </div>
    </div>

    <div class="bookings hidden">
      <button class="close-btn">Close</button>
      <h2>Bookings</h2>

      <?php

        $re = mysqli_query($conn, "SELECT * FROM bite");

        if(mysqli_num_rows($re) > 0) {
          // Loop through each row of data
          while($ret = mysqli_fetch_array($re)) {
              // Extracting data from the row
              $Dname = $ret['name'];
              $Ddate = $ret['date'];
              $Dtime = $ret['time'];
              $Dpeople = $ret['people'];
              $Dtable = $ret['tables'];

              echo '<div class="booking">';
              echo '<h3>' . htmlspecialchars($Dname) . '</h3>';
              echo '<p>Date: ' . htmlspecialchars($Ddate) . '</p>';
              echo '<p>Time: ' . htmlspecialchars($Dtime) . '</p>';
              echo '<p>Number of People: ' . htmlspecialchars($Dpeople) . '</p>';
              echo '<p>Table: ' . htmlspecialchars($Dtable) . '</p>';
              echo '</div>';
          }
        }

      ?>

      
      <!-- More booking entries can be added here -->
    </div>

    <script src="script.js"></script>
  </body>
</html>
