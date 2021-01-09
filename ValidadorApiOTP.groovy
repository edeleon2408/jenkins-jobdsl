validador_api_otp_multibranch = "Validador-api-otp/ms-api-otp"
validador_admin_otp_multibranch = "Validador-api-otp/admin-otp"
api_preguntas_multibranch = "Api-preguntas/api-preguntas"

repo_validador_api_otp = "https://github.com/edeleon2408/validador-api-otp.git";
repo_validador_admin_otp = "https://github.com/edeleon2408/validador-api-otp.git";
repo_api_preguntas = "https://github.com/edeleon2408/validador-api-otp.git";

folder_name_validador_otp = "Validador-api-otp"
folder_name_api_preguntas = "Api-preguntas"

view_name_validador_otp = "Validador-api-otp"
view_name_api_preguntas = "Api-preguntas"

//Folder para el Proyecto Validador OTP
folder(folder_name_validador_otp){
        displayName(folder_name_validador_otp)
        description('Folder para proyectos de Validador OTP')
}

//Folder para el Proyecto Api Preguntas
folder(folder_name_api_preguntas){
        displayName(folder_name_api_preguntas)
        description('Folder para proyectos de Api Preguntas')
}

//Multibranch para el API de OTP
multibranchPipelineJob(validador_api_otp_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('validador-api-otp-id')
            remote(repo_validador_api_otp)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

//Multibranch para Admin OTP
multibranchPipelineJob(validador_admin_otp_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('validador-admin-otp-id')
            remote(repo_validador_admin_otp)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

//Multibranch para Api Preguntas
multibranchPipelineJob(api_preguntas_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('api-preguntas-id')
            remote(repo_api_preguntas)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

//Vista para el Proyecto Validador OTP
listView(view_name_validador_otp){
        description('Vista que contendrá todas las tareas del proyecto Validador OTP')
        jobs {
                regex(/.*Validador.*/)
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

//Vista para el Proyecto Api Preguntas
listView(view_name_api_preguntas){
        description('Vista que contendrá todas las tareas del proyecto Api preguntas')
        jobs {
                regex(/.*preguntas.*/)
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
