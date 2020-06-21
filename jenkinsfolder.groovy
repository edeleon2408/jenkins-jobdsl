project_name_multibranch = "Enrolamiento-api/mb-enrolamiento-api"
repo_files_groovy = "https://github.com/edeleon2408/enrolamiento-api.git";
folder_name = "Enrolamiento-api"
view_name = "Enrolamiento-api"


folder(folder_name){
displayName(folder_name)
description('Folder para proyectos de Enrolamientos')
}

multibranchPipelineJob(project_name_multibranch) {
triggers {
        periodic(1)
    }
    branchSources {
        git {
id('enrolamiento-api-id')
            remote(repo_files_groovy)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

listView(view_name){
description('Vista que contendrá todas las tareas del proyecto Enrolamiento-api')
jobs {
regex(/.*Enrolamiento.*/)
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

