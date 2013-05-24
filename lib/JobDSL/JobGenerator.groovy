package lib.JobDSL

class JobGenerator {
	static Closure developerFeedback(String projectPath, List<String> recipients) {
		def projectName = Misc.pathToName(projectPath)
		def jobName = "${projectName}_DevFeedback"
		return {
			name jobName
			scm Perforce.config(projectPath)
			triggers { scm("* * * * *") }
			configure Misc.restrictTo('ios-builds&&xcode46')
	
			steps {
				shell('rake ci:dev_feedback')
			}
			
			// Works with this here
			publishers Email.notification(recipients)
			
			configure Analysis.warnings()
			configure Cobertura.coverage("build/coverage.xml")
			configure Junit.report("build/test-reports/*.xml")
			
			// Does not work if publishers block is here, instead
			// publishers Email.notification(recipients)
		}
	}
}
