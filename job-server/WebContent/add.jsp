<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Online dictinary service that allows you to search for a definition of english words">
    <meta name="author" content="Adrian Sypos">

    <title>Add | Dictionary Service</title>

    <!-- Bootstrap core CSS -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="style.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	

  </head>

  <body>

    <!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="#">Dictionary Service</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="/job-server">Search</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/job-server/add.jsp">Add <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link disabled" href="/job-server/delete.jsp">Delete</a>
	      </li>
	    </ul>
	    <form class="form-inline my-2 my-lg-0" action="lookup" method="post">
	      <input class="form-control mr-sm-2" name="word" type="text" placeholder="Search" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	    </form>
	  </div>
	</nav>

    <!-- Masthead -->
    <header class="masthead text-white text-center">
      <div class="overlay"></div>
      <div class="container">
      
      <div class="col-xl-9 mx-auto">
         <h1 class="mb-5">Add to dictionary service</h1>
      </div>

	  <form action="add" method="post">
	    <div class="form-group row">
	      <label for="key" class="col-sm-2 col-form-label">Word</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" name="key" placeholder="Enter the word you wish to add..">
	      </div>
	    </div>
	    <div class="form-group row">
	      <label for="desc" class="col-sm-2 col-form-label">Description</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" name="desc" placeholder="Enter description of the word..">
	      </div>
	    </div>
	    <div class="form-group row">
	      <div class="offset-sm-2 col-sm-10">
	        <button type="submit" class="btn btn-primary">Add</button>
	      </div>
	    </div>
	  </form>
	</div>
      <div class="col-xl-9 mx-auto">
      </br></br>
        <h5 class="mb-5" style="color: lightblue">${messages.description}</h5>
      </div>
    </header>
    
  </body>

</html>