multibranchPipelineJob('multi-branch-angular-docker') {
	triggers {
        periodic(1)
    }
    branchSources {
        git {
			id('angular-docker-id')
            remote("https://github.com/edeleon2408/angular-docker.git")
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}