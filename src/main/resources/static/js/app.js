var app=angular.module("MyApp",['ui.router']);	

app.config(function($stateProvider, $urlRouterProvider){
	
	$stateProvider.state('home',
		{url:'/home', 
		templateUrl: '/views/home.html',
		controller:'HomeController'});
	
	$stateProvider.state('chercher',
			{url:'/chercher', 
			templateUrl: '/views/chercher.html',
			controller:'MyController'});
	
	$stateProvider.state('newProduit',
			{url:'/newProduit', 
			templateUrl: '/views/newProduit.html',
			controller:'NewProduitController'});
 
});

app.controller("HomeController", function(){
	
});
app.controller("NewProduitController", function(){
	
});

app.controller("MyController",function($scope,$http){
	
	$scope.pageProduits=null;
	$scope.motCle="";
	$scope.size=4;
	$scope.pages=[];
	$scope.chercherProduits= function(){
		$http.get("http://localhost:8080/chercherProduits?mc="
				+$scope.motCle+"&page="+$scope.pageCourante+"&size="+$scope.size)
		  .then(function (response) {
			  
		    var data = response.data;
		    var status = response.status;
		    var statusText = response.statusText;
		    var headers = response.headers;
		    var config = response.config;
		    $scope.pageProduits = data;
		    $scope.pages= new Array(data.totalPages) 
		    console.log(data);
		});
	}
	$scope.getProduits=function(){
		$scope.pageCourante=0;
		$scope.chercherProduits()
	}
	$scope.gotoPage= function(p){
		$scope.pageCourante=p;
		$scope.chercherProduits()
	}
	
	
});