validador_api_otp_multibranch = "Validador-api-otp/ms-api-otp"
validador_admin_otp_multibranch = "Validador-api-otp/admin-otp"
repo_validador_api_otp = "https://github.com/edeleon2408/validador-api-otp.git";
repo_validador_admin_otp = "https://github.com/edeleon2408/validador-api-otp.git";
folder_name = "Validador-api-otp"
view_name = "Validador-api-otp"


folder(folder_name){
displayName(folder_name)
description('Folder para proyectos de Validador OTP')
}

//Multibranch para el API de OTP
multibranchPipelineJob(validador_api_otp_multibranch) {
triggers {
        periodic(1)
    }
    branchSources {
        git {
id('enrollment-api-id')
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
id('enrollment-experian-id')
            remote(repo_validador_admin_otp)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

listView(view_name){
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
