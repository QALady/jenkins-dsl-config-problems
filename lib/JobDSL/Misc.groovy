package lib.JobDSL

class Misc {
	static Closure restrictTo(label) {
		return { project ->
			project / assignedNode(label)
			project / canRoam('false')
		}
	}
	
	static String pathToName(path) {
		return path.replace('/', '_')
	}
}
