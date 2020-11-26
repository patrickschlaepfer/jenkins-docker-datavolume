#!groovy

// imports
import jenkins.model.*
import hudson.security.*
import jenkins.model.IdStrategy


// parameters
def jenkinsParameters = [
  email:  'Jenkins Admin <admin@jenkins.com>',
  url:    'http://18.193.172.241/node1/'
]

// get Jenkins location configuration
def jenkinsLocationConfiguration = JenkinsLocationConfiguration.get()

// set Jenkins URL
jenkinsLocationConfiguration.setUrl(jenkinsParameters.url)

// set Jenkins admin email address
jenkinsLocationConfiguration.setAdminAddress(jenkinsParameters.email)

// save current Jenkins state to disk
jenkinsLocationConfiguration.save()

def instance = Jenkins.getInstance()

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("jenkins","jenkins123")

instance.setSecurityRealm(hudsonRealm)
instance.save()
