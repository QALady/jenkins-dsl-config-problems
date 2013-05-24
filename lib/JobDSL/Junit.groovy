package lib.JobDSL

// Re-implementation of code from newer versions of JobDSL plugin that doesn't exist in 1.9
class Junit {
	static Closure report(String glob) {
		return { project ->
			def junitArchiverNode = project / publishers / 'hudson.tasks.junit.JUnitResultArchiver'
			
			junitArchiverNode / testResults(glob)
			junitArchiverNode / keepLongStdio('false')
			junitArchiverNode / testDataPublishers('')
		}
	}
}
