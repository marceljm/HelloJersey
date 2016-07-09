app.controller('myCtrl', function($scope, $location, $http, $timeout, $interval) {
	$scope.firstName = "John";
	$scope.lastName = "Jacques";
	$scope.myScope = 'controller';
	$scope.myUrl = $location.absUrl();

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

	$scope.select = function() {
		$http.get("rest/products").then(function(response) {
			$scope.content = response.data;
			$scope.statuscode = response.status;
			$scope.statustext = response.statusText;
			$scope.config = response.config;
			$scope.headers = response.headers;
			$scope.products = response.data.products;
		});
	};

	$http.get("wrongfilename.htm").then(function(response) {
		$scope.responseData = response.data;
	}, function(response) {
		$scope.responseData = "Something went wrong";
	});

	$scope.update = function() {
		$scope.putJson = '{ "product": { "id": 1, "name": "Home Theater" } }';
		$http.put("rest/products", $scope.putJson).then(function(response) {
			$scope.putData = response.data;			
		});
	};
	
	$scope.insert = function() {
		$scope.insertJson = '{ "product": { "id": 1, "name": "TV" } }';
		$http.post("rest/products", $scope.insertJson).then(function(response) {
			$scope.postData = response.data;
		});
	};
	
	$scope.delete = function() {
		$http.delete("rest/products/1").then(function(response) {
			$scope.deleteData = response.data;
		});
	};

	$timeout(function() {
		$scope.firstName = "TIMEOUT!!!";
	}, 10000);

});

app.run(function($rootScope) {
	$rootScope.myScope = "root";
});

app.filter('myFormat', function() {
	return function(x) {
		var i, c, txt = "";
		for (i = 0; i < x.length; i++) {
			c = x[i];
			if (i % 2 == 0) {
				c = c.toUpperCase();
			}
			txt += c;
		}
		return txt;
	};
});

app.controller('myCtrlInterval', function($interval, $scope, hexafy, $http) {
	$scope.theTime = new Date().toLocaleTimeString();

	$interval(function() {
		$scope.theTime = new Date().toLocaleTimeString();
	}, 1000);

	$scope.hex = hexafy.myFunc(255);
	
    $scope.cars = {
    		car01 : {brand : "Ford", model : "Mustang", color : "red"},
    		car02 : {brand : "Fiat", model : "500", color : "white"},
    		car03 : {brand : "Volvo", model : "XC90", color : "black"}
    }
    
    $scope.count = 0;
    
    $scope.x1 = angular.isNumber(12345);
    $scope.x2 = angular.isString("test");
});

app.service('hexafy', function() {
	this.myFunc = function(x) {
		return x.toString(16);
	}
});

app.directive('myDirective', function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attr, mCtrl) {
            function myValidation(value) {
                if (value.indexOf("e") > -1) {
                    mCtrl.$setValidity('charE', true);
                } else {
                    mCtrl.$setValidity('charE', false);
                }
                return value;
            }
            mCtrl.$parsers.push(myValidation);
        }
    };
});

app.config(function($sceDelegateProvider) {
    $sceDelegateProvider.resourceUrlWhitelist([
        'http://www.refsnesdata.no/**',
        'http://localhost:8080/HelloJersey/**',
    ]);
});

// To enable the code below, comment the code above
app.config(function($routeProvider) {
    $routeProvider
    .when("", {
        templateUrl : "index.html"
    })
    .when("/a", {
        templateUrl : "A.html"
    })
    .when("/b", {
        templateUrl : "B.html"
    })
});