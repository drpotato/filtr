(function() {
	var filtr = angular.module('filtr', ['ui.bootstrap']);
	
	filtr.controller('ProfanityController', function($scope, $http) {
		
		$scope.profanities = [];
		
		$scope.newProfanity = {};
		
		$http.get("/filtr/api/profanity/")
		.success(function(data, status, headers, config) {
			$scope.profanities = data;
		})
		.error(function(data, status, headers, config) {
			console.log("Oops...");
		});
		
		$scope.add = function(profanity) {
			
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
		
		
		$scope.delete = function(profanity) {
			
			
			$http({"method": "DELETE", "url": "/filtr/api/profanity/", "data": profanity, "headers": {"Content-Type": "application/json", "Accept": "application/json"}})
			.success(function(data, status, headers, config) {
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);
			})
			.error(function(data, status, headers, config) {
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);
			});
			var index = $scope.profanities.indexOf(profanity);
			$scope.profanities.splice(index, 1);
			
		};
	});
	
})();
