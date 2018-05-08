// Exported from:        http://Ravans-MBP.xebialabs.com:5516/#/templates/Folder7a078f0cdf044abfbbb7ea5011364669-Folder548070c88cd54d3e8ea5f3e3ab4f31f0-Folderb26fe22413094384b2e6d83e3c1fbd47-Folder1eeb75cb109454899e83784f7e4f527-Release3f706b9913844d3cb20ee037f3ccd074/releasefile
// XL Release version:   8.0.1
// Date created:         Tue May 08 11:32:44 CEST 2018

def release_id = xlr {
  release('Catalog Component Release') {
    variables {
      booleanVariable('run_build') {
         required false        
      }
      stringVariable('release_catalog_id') {
        required false
        showOnReleaseStart false
      }
      stringVariable('mode') {
        value 'demo'
      }
    }
    scheduledStartDate Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", '2018-05-08T09:00:00+0200')
    scriptUsername 'admin'
    scriptUserPassword 'admin'
    phases {
      phase('Release component') {
        color '#0099CC'
        tasks {
          createRelease('Release Catalog Component') {
            newReleaseTitle 'Release Catalog Component'
            template 'CoolStore Microservices Project/Technical release/deploy/component/Component Continuous Delivery Template'
            templateVariables {
              stringVariable('appVersion') {
                value '2.3'
              }
              stringVariable('buildConfigName') {
                value 'catalog'
              }
              stringVariable('buildProject') {
                value 'coolstore-build'
              }
              stringVariable('gitRef') {
                value 'master'
              }
              stringVariable('gitUri') {
                value 'https://github.com/ravan/coolstore-catalog-spring-boot'
              }
              stringVariable('streamName') {
                value 'catalog'
              }
              stringVariable('streamTag') {
                value '2.3'
              }
              stringVariable('useBuildImage') {
                value 'redhat-openjdk18-openshift:1.1'
              }
              stringVariable('xld_url') {
                value '${global.xlr_url}'
              }
              stringVariable('buildDefinitionCommand') {
                value 'replace'
              }
              booleanVariable('runBuild') {
                value '${run_build}'
              }
              stringVariable('component') {
                value 'catalog'
              }
              stringVariable('mode') {
                value '${mode}'
              }
              stringVariable('deployment_package') {
                value 'Coolstore/Services/catalog/2.3'
              }
            }
            createdReleaseId '${release_catalog_id}'
          }
          gate('Wait for release completion') {
            dependencies {
              dependency {
                variable 'release_catalog_id'
              }
            }
          }
        }
      }
    }
  }
}
releaseVariables['component_release_id'] = release_id

