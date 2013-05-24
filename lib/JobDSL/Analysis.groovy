package lib.JobDSL

class Analysis {
	static Closure warnings() {
		return { project -> 
			def analysisNode = project / publishers / 'hudson.plugins.warnings.WarningsPublisher'(plugin: 'warnings@4.25')
			
			analysisNode / consoleParsers / 'hudson.plugins.warnings.ConsoleParser' / parserName('Clang (LLVM based)')
				
			// Nothing interesting down here, but provide everything it's looking for
			analysisNode / healthy('')
			analysisNode / unHealthy('')
			analysisNode / thresholdLimit('low')
			analysisNode / pluginName('[WARNINGS] ')
			analysisNode / defaultEncoding('')
			analysisNode / canRunOnFailed('false')
			analysisNode / useStableBuildAsReference('false')
			analysisNode / useDeltaValues('false')
			analysisNode / shouldDetectModules('false')
			analysisNode / dontComputeNew('true')
			analysisNode / doNotResolveRelativePaths('true')
			analysisNode / parserConfigurations('')
			
			def thresholdsNode =  analysisNode / thresholds(plugin:"analysis-core@1.49")
			thresholdsNode / unstableTotalAll('')
			thresholdsNode / unstableTotalHigh('')
			thresholdsNode / unstableTotalNormal('')
			thresholdsNode / unstableTotalLow('')
			thresholdsNode / failedTotalAll('')
			thresholdsNode / failedTotalHigh('')
			thresholdsNode / failedTotalNormal('')
			thresholdsNode / failedTotalLow('')
		}
	}
}


