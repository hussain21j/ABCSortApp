<!DOCTYPE HTML>
<html ng-app="HMSortApp">
<head>
<title>H&m Sorting App</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

	<div class="container">
		<div class="row">
			<h3>H&M Sorting Application</h3>
			<hr />
			<div ng-app="angularjs-starter" ng-controller="MainCtrl">
				<fieldset data-ng-repeat="number in numbers">
					<input type="number" ng-model="number.value" name=""
						placeholder="Enter Number" size="10" min="0" max="10000000"
						required>
					<button class="remove" ng-show="$last" ng-click="removeNumber()">-</button>
				</fieldset>
				<button class="addfields" ng-click="addNewNumber()">Add
					Number</button>
				<button class="addfields" ng-click="getSorted()">Sort
					Numbers</button>
				<button class="addfields" ng-click="getHistorySorts()">Sort
					History</button>

				<br> <br>
				<div id="divSortOutput">
					<h4>Sort Output</h4>
					<table>
						<thead>
							<th>Unsorted Numbers</th>
							<th>Sorted Numbers</th>
							<th>Total Movements</th>
							<th>Time Taken (In Nano Seconds)</th>
						</thead>
						<tbody>
							<tr>
								<td>{{sortedInfoData.originaNumberArray}}</td>
								<td>{{sortedInfoData.sortedNumberArray}}</td>
								<td>{{sortedInfoData.shuffleCount}}</td>
								<td>{{sortedInfoData.totalTimeConsumed}}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<br> <br>
				<div id="divPreviousSortResults">
					<h4>History Of your Sorts</h4>
					<table>
						<thead>
							<th>Unsorted Numbers</th>
							<th>Sorted Numbers</th>
							<th>Total Movements</th>
							<th>Time Taken (In Nano Seconds)</th>
						</thead>
						<tbody>
							<tr ng-repeat="sortDataInfo in sortDataInfoList">
								<td>{{sortDataInfo.originaNumberArray}}</td>
								<td>{{sortDataInfo.sortedNumberArray}}</td>
								<td>{{sortDataInfo.shuffleCount}}</td>
								<td>{{sortDataInfo.totalTimeConsumed}}</td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>

		</div>
	</div>

	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>

	<div class="footer">
		<div class="container">
			<p class="row text-muted">You Can add multiple numbers by
				clicking on the Add Number Button</p>
			<p class="row text-muted">Hit Sort Numbers to sort the number</p>
			<p class="row text-muted">Hit Sort History Button to get Sort
				History</p>
		</div>
	</div>
</body>
</html>