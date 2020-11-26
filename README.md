# jenkins-docker-datavolume

Setup von mehreren Jenkins Docker Container mit einem Docker Datavolumen.

## Lightsail

Das Testsystem ist eine AWS Lightsail Instanz mit Ubuntu 20.24 LTS

https://itnext.io/how-to-set-up-python-virtual-environment-on-ubuntu-20-04-a2c7a192938d



$ sudo apt update

$ sudo apt install python3-pip



$ mkdir .virtualenv

$ pip3 -V
pip 20.0.2 from /usr/lib/python3/dist-packages/pip (python 3.8)

$ sudo pip3 install virtualenvwrapper



.bashrc
#Virtualenvwrapper settings:
export WORKON_HOME=$HOME/.virtualenvs
VIRTUALENVWRAPPER_PYTHON=/usr/bin/python3
. /usr/local/bin/virtualenvwrapper.sh

$ source ~/.bashrc

$ mkvirtualenv name_of_your_env

deactivate
workon
lsvirtualenv
workon name_of_your_env
rmvirtualenv name_of_your_env
cpvirtualenv old_virtual_env new_virtual_env


https://docs.docker.com/engine/install/ubuntu/



docker.io Paket ist aus dem Ubuntu Repo.

```

#!/usr/bin/bash

sudo apt-get install \
  apt-transport-https \
  ca-certificates \
  curl \
  gnupg-agent \
  software-properties-common

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

sudo add-apt-repository \
  "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) \
  stable"

sudo apt-get update

sudo apt-get install docker-ce docker-ce-cli containerd.io

```



$ sudo groupadd docker

$ sudo usermod -aG docker $USER



$ sudo systemctl enable docker



$ ansible-playbook -c local -i localhost, playbook.yml



```

sudo docker run -d --name jenkins_prod -p 8080:8080\

-p 50000:50000 -v jenkins-home-prod:/var/jenkins_home \

jenkins/jenkins:lts

```



```

sudo docker exec -it jenkins_prod ls -lrt /var/jenkins_home

```



localhost ansible_host=127.0.0.1



[local]

localhost



[local:vars]

ansible_connection=local


