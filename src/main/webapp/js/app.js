(function() {
	var filtr = angular.module('filtr', ['ui.bootstrap']);
	
	filtr.controller('ProfanityController', function($scope, $http) {
		
		$scope.profanities = []
		
		this.newProfanity = {}
		
		$http.get("/filtr/api/profanity/")
		.success(function(data, status, headers, config) {
			$scope.profanities = data;
			console.log($scope.profanities);
		})
		.error(function(data, status, headers, config) {
			console.log("Oops...");
		});
		
		this.addProfanity = function(profanity) {
			$scope.profanities.push(profanity)
			$scope.NewProfanity = {}
		};
		
	});
	
})();
