(function() {
	var filtr = angular.module('filtr', ['ui.bootstrap']);
	
	filtr.controller('AppController', function($scope, $http) {
		
		$scope.activeList = {};
		
		$scope.allProfanities = [];
		$scope.wordLists = [];
		
		$scope.newProfanity = {};
		$scope.newList = {};
		
		$http.get("/filtr/api/word_list/")
		.success(function(data, status, headers, config) {
			$scope.wordLists = data.sort(function(a, b) {
				return a.id - b.id;
			});
			
			for (var i = 0; i < $scope.wordLists.length; i++) {
				$scope.wordLists[i].profanities = $scope.wordLists[i].profanities.sort(function(a, b) {
					return a.id - b.id;
				}); 
			}
			
			if ($scope.wordLists.length > 0) {
				$scope.activeList = $scope.wordLists[0];
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
			$scope.allProfanities = data.sort(function(a, b) {
				return a.id - b.id;
			});
			console.log($scope.allProfanities);
		})
		.error(function(data, status, headers, config) {
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);	
			});
		
		$scope.changeActiveList = function(wordList) {
			$scope.activeList = wordList;
		}
		
		$scope.addList = function(wordList) {
			
			
			if (angular.equals({}, wordList)) {
				return false;
			}
			
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
		
		$scope.addToList = function(profanity) {
			
			
			$http({"method": "PUT", "url": "/filtr/api/word_list/add_profanity/" + $scope.activeList.id, "data": profanity, "headers": {"Content-Type": "application/json", "Accept": "application/json"}})
			.success(function(data, status, headers, config) {
				console.log(data);
				$scope.activeList.profanities.push(data);
			})
			.error(function(data, status, headers, config) {
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);
			});
		}
		
		$scope.removeFromList = function(profanity) {
			
			$http({"method": "DELETE", "url": "/filtr/api/word_list/remove_profanity/" + $scope.activeList.id, "data": profanity, "headers": {"Content-Type": "application/json", "Accept": "application/json"}})
			.success(function(data, status, headers, config) {
				console.log(data);
				var index = $scope.activeList.profanities.indexOf(profanity);
				$scope.activeList.profanities.splice(index, 1);
			})
			.error(function(data, status, headers, config) {
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);
			});
		}
		
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
