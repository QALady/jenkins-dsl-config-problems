package lib.JobDSL

class Cobertura {
	static Closure coverage(String testResults) {
		return { project ->
			def coberturaNode =  project / publishers / 'hudson.plugins.cobertura.CoberturaPublisher'(plugin: "cobertura@1.7.1")
			
			coberturaNode / coberturaReportFile(testResults)
			coberturaNode / onlyStable('false')
			coberturaNode / failUnhealthy('false')
			coberturaNode / failUnstable('false')
			coberturaNode / autoUpdateHealth('false')
			coberturaNode / autoUpdateStability('false')
			coberturaNode / zoomCoverageChart('false')
			coberturaNode / failNoReports('true')
 			coberturaNode / healthyTarget / targets('')
 			coberturaNode / unhealthyTarget / targets('')
 			coberturaNode / failingTarget / targets('')
			coberturaNode / sourceEncoding('ASCII')
		}
	}
}
