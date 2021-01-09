enrollment_api_multibranch = "Enrollment/Enrollment-api"
enrollment_experian_multibranch = "Enrollment/Enrollment-experian"
repo_enrollment_api = "https://github.com/edeleon2408/enrolamiento-api.git";
repo_enrollment_experian = "https://github.com/edeleon2408/enrolamiento-api.git";
folder_name = "Enrollment"
view_name = "Enrollment"


folder(folder_name){
displayName(folder_name)
description('Folder para proyectos de Enrolamiento')
}

//Multibranch para el API de Enrollment
multibranchPipelineJob(enrollment_api_multibranch) {
triggers {
        periodic(1)
    }
    branchSources {
        git {
id('enrollment-api-id')
            remote(repo_enrollment_api)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

//Multibranch para el servicio de pasarela de Experian
multibranchPipelineJob(enrollment_experian_multibranch) {
triggers {
        periodic(1)
    }
    branchSources {
        git {
id('enrollment-experian-id')
            remote(repo_enrollment_experian)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

listView(view_name){
description('Vista que contendrá todas las tareas del proyecto Enrollment')
jobs {
regex(/.*Enrollment.*/)
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

