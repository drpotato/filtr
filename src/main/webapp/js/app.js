(function() {
	var filtr = angular.module('filtr', ['ui.bootstrap']);
	
	filtr.controller('ProfanityController', function($scope, $http) {
		
		$scope.profanities = [];
		
		$scope.newProfanity = {};
		
		$http.get("/filtr/api/profanity/")
		.success(function(data, status, headers, config) {
			$scope.profanities = data;
			console.log($scope.profanities);
		})
		.error(function(data, status, headers, config) {
			console.log("Oops...");
		});
		
		$scope.addProfanity = function(profanity) {
			
			$http.post("/filtr/api/profanity/", profanity)
			.success(function(data, status, headers, config) {
				console.log(data);
			})
			.error(function(data, status, headers, config) {
				console.log(data);
			});
			
			$scope.profanities.push(profanity);
			$scope.newProfanity = {};
		};
		
	});
	
})();
