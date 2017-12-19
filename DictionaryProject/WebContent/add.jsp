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
    <link href="bootstrap.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-light bg-light static-top">
      <div class="container">
        <a class="navbar-brand" href="/DictionaryProject">Dictionary Service</a>
        <a class="btn btn-primary" href="/DictionaryProject/add.jsp">Add</a>
      </div>
    </nav>

    <!-- Masthead -->
    <header class="masthead text-white text-center">
      <div class="overlay"></div>
      <div class="container">
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
    
    <!-- Bootstrap core JavaScript -->
    <script src="jquery.min.js"></script>
    <script src="bootstrap.bundle.min.js"></script>

  </body>

</html>