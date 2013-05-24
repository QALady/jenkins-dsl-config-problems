package lib.JobDSL

class Email {
	private static String emailContent = '''\
${PROJECT_NAME} - Build # ${BUILD_NUMBER} - ${BUILD_STATUS}:
Check console output at <${BUILD_URL}> to view the results.

${FAILED_TESTS}

Changes since last build:
${CHANGES}
'''
	
	static Closure notification(List<String> recipients) {
		return {
			extendedEmail(recipients.join(', '), null, emailContent) {
				// Tell everyone everything. This may not be scalable
				trigger('Failure', null, null, null, true, true, true, true)
				trigger('Success', null, null, null, true, true, true, true)
				trigger('Unstable', null, null, null, true, true, true, true)
				
				configure { node ->
					node / contentType('text/plain')
				}
			}
		}
	}
}
