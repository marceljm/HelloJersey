app.controller('myCtrl', function($scope) {
	$scope.firstName = "John";
	$scope.lastName = "Jacques";
	$scope.myScope = 'controller';

	$scope.changeName = function() {
		$scope.lastName = "AngularJS";
	}

	$scope.fullName = function() {
		return $scope.firstName + " " + $scope.lastName;
	};

	$scope.names = [ {
		name : 'Jani',
		country : 'Norway'
	}, {
		name : 'Hege',
		country : 'Sweden'
	}, {
		name : 'Kai',
		country : 'Denmark'
	} ];
});

app.run(function($rootScope) {
	$rootScope.myScope = "root";
});