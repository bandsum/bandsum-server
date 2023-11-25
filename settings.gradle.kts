rootProject.name = "bandsum"

include("libs")
project(":libs").projectDir = file("bandsum-libs")
include("domain")
project(":domain").projectDir = file("bandsum-domain")
include("data")
project(":data").projectDir = file("bandsum-data")
include("app")
project(":app").projectDir = file("bandsum-app")
