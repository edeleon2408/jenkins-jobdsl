folder('Enrolamiento'){
displayName('Enrolamiento')
description('Folder para proyectos de Enrolamientos')
}

multibranchPipelineJob('Enrolamiento/mb-project-a-angular-docker') {
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

listView('Enrolamiento'){
description('Vista que contendrá todos los jobs del proyecto')
jobs {
regex('/.*Enrolamiento.*/')
}
columns {
status()
weather()
name()
lastSuccess()
lastFailure()
lastDuration()
buildButton()
}

}

