validador_otp_api_multibranch = "stg-validador-otp/otp-api"
validador_otp_admin_multibranch = "stg-validador-otp/otp-admin"
validador_otp_admin_conf_api_multibranch = "stg-validador-otp/otp-admin-conf-api"
validador_preguntas_api_multibranch = "stg-validador-preguntas/preguntas-api"

repo_validador_otp_api = "";
repo_validador_otp_admin = "";
repo_validador_otp_admin_conf_api = "";
repo_validador_preguntas_api = "";

folder_name_validador_otp = "stg-validador-otp"
folder_name_validador_preguntas = "stg-validador-preguntas"

view_name = "Staging"

//Folder para el Proyecto Validador OTP
folder(folder_name_validador_otp){
        displayName(folder_name_validador_otp)
        description('Folder para proyectos de Validador OTP')
}

//Folder para el Proyecto Api Preguntas
folder(folder_name_validador_preguntas){
        displayName(folder_name_validador_preguntas)
        description('Folder para proyectos de Validador Preguntas Api')
}

//Multibranch para el OTP API
multibranchPipelineJob(validador_otp_api_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('stg-validador-otp-api-id')
            remote(repo_validador_otp_api)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

//Multibranch para Admin OTP
multibranchPipelineJob(validador_otp_admin_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('stg-validador-otp-admin-id')
            remote(repo_validador_otp_admin)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

//Multibranch para OTP Admin Configuración API
multibranchPipelineJob(validador_otp_admin_conf_api_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('stg-validador-otp-admin-conf-api-id')
            remote(repo_validador_otp_admin_conf_api)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}


//Multibranch para Preguntas Api
multibranchPipelineJob(validador_preguntas_api_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('stg-validador-preguntas-api-id')
            remote(repo_validador_preguntas_api)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

//Vista para los Proyectos del ambiente de desarrollo
listView(view_name){
        description('Vista que contendrá todas las tareas del ambiente de Staging para cualquier proyecto')
        jobs {
                regex(/.*stg.*/)
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
