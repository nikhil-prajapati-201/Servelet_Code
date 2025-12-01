<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
<link rel="stylesheet" href="profile.css">
<link rel="icon" type="image/png" href="images/graduated.png">
</head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
<link rel="stylesheet" href="profile.css">
</head>

<body>

<div class="page-bg">

    <div class="profile-card">
        <h2>${firstname}'s Profile</h2>

        <div class="profile-container">

            <div class="profile-row">
                <span>Full Name: </span>${firstname} ${lastname}
            </div>
            
            <div class="profile-row">
                <span>Email: </span>${email}
            </div>
            
            <div class="profile-row">
                <span>Phone: </span>${phone}
            </div>
            
             <div class="profile-row">
                <span>Date: </span>${dob}
            </div>
            
            <div class="profile-row">
                <span>Gender: </span>${gender}
            </div>
            
            <div class="profile-row">
                <span>Enroll: </span>${enrollment}
            </div>
            
            <div class="profile-row">
                <span>Semester: </span>${semester}
            </div>
            
            <div class="profile-row">
                <span>Course: </span>${course}
            </div>
            
            <div class="profile-row">
                <span>Department: </span>${department}
            </div>
            
             <div class="profile-row">
                <span>Address: </span>${Address}
            </div>
            
            <div class="profile-row">
                <span>City: </span>${City}
            </div>
            
            <div class="profile-row">
                <span>State: </span>${State}
            </div>
            
      
            
            </div>
            
           
    
        </div>
    </div>

</div>

</body>
</html>

</html>
