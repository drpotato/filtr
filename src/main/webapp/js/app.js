(function() {
	var filtr = angular.module('filtr', ['ui.bootstrap']);
	
	filtr.controller('AppController', function($scope, $http) {
		
		$scope.activeList = 0;
		
		$scope.allProfanities = [];
		$scope.wordLists = [];
		
		$scope.newProfanity = {};
		$scope.newList = {};
		
		$http.get("/filtr/api/word_list/")
		.success(function(data, status, headers, config) {
			$scope.wordLists = data;
			if ($scope.wordLists.length > 0) {
				$scope.activeList = 1;
			}
		})
		.error(function(data, status, headers, config) {
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);	
			});
		
		$http.get("/filtr/api/profanity/")
		.success(function(data, status, headers, config) {
			$scope.allProfanities = data;
		})
		.error(function(data, status, headers, config) {
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);	
			});
		
		$scope.addList = function(wordList) {
			
			
			if (angular.equals({}, wordList)) {
				return false;
			}
			
			wordList.profanities = [];
			
			$http({"method": "POST", "url": "/filtr/api/word_list/", "data": wordList, "headers": {"Content-Type": "application/json", "Accept": "application/json"}})
			.success(function(data, status, headers, config) {
				$scope.wordLists.push(data);
				$scope.newList = {};
			})
			.error(function(data, status, headers, config) {
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);	
			});
			
		};
		
		$scope.addProfanity = function(profanity) {
			
			if (angular.equals({}, profanity)) {
				return false;
			}
			
			$http.post("/filtr/api/profanity/", profanity)
			.success(function(data, status, headers, config) {
				$scope.allProfanities.push(data);
				$scope.newProfanity = {};
			})
			.error(function(data, status, headers, config) {
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);	
			});
		};
		
		$scope.delete = function(profanity) {
			
			$http({"method": "DELETE", "url": "/filtr/api/profanity/", "data": profanity, "headers": {"Content-Type": "application/json", "Accept": "application/json"}})
			.success(function(data, status, headers, config) {
				console.log(data);
				var index = $scope.profanities.indexOf(profanity);
				$scope.profanities.splice(index, 1);
			})
			.error(function(data, status, headers, config) {
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);
			});
			
			
		};
	});
	
})();
