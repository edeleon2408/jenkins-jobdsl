multibranchPipelineJob('multi-branch-docker-war') {
	triggers {
        periodic(1)
    }
    branchSources {
        git {
            remote("https://github.com/edeleon2408/jenkins-docker-war.git")
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}