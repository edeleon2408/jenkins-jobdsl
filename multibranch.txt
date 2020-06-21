multibranchPipelineJob('multi-branch-docker-spring-boot-war') {
	triggers {
        periodic(1)
    }
    branchSources {
        git {
			id('jenkins-docker-war-id')
            remote("https://github.com/edeleon2408/jenkins-docker-war.git")
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}