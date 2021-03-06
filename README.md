# jenkins-docker-datavolume

Setup von mehreren Jenkins Docker Container mit einem Docker Datavolumen.

## Lightsail

Das Testsystem ist eine AWS Lightsail Instanz mit Ubuntu 20.24 LTS

## Installation python

Anleitung: https://itnext.io/how-to-set-up-python-virtual-environment-on-ubuntu-20-04-a2c7a192938d

```
$ sudo apt update
$ sudo apt install python3-pip
```

### Erstellen virtualenv

```
$ mkdir .virtualenv
$ pip3 -V
pip 20.0.2 from /usr/lib/python3/dist-packages/pip (python 3.8)
$ sudo pip3 install virtualenvwrapper
```

Folgendes Snipplet am Ende von .bashrc hinzfügen
```
#Virtualenvwrapper settings:
export WORKON_HOME=$HOME/.virtualenvs
VIRTUALENVWRAPPER_PYTHON=/usr/bin/python3
. /usr/local/bin/virtualenvwrapper.sh
```

```
$ source ~/.bashrc
```

```
$ mkvirtualenv name_of_your_env
```

Befehle zur Verwaltung von virtualenvs

```
deactivate
workon
lsvirtualenv
workon name_of_your_env
rmvirtualenv name_of_your_env
cpvirtualenv old_virtual_env new_virtual_env
```

### Erstellen venv für ansible 2.10

```
$ mkvirtualenv ansible2_10
$ pip install ansible
$ pip install docker
```

### Tweaking Python

https://github.com/ansible/ansible/issues/14468

```
cd /tmp
apt-get download python3-apt
dpkg -x python3-apt_0.9.3.5ubuntu3_amd64.deb python3-apt

cp -r /tmp/python3-apt/usr/lib/python3/dist-packages/* /home/ubuntu/python3.6.8-venv/lib/python3.6/site-packages/

cd /home/ubuntu/python3.6.8-venv/lib/python3.6/site-packages/
mv apt_pkg.cpython-34m-x86_64-linux-gnu.so apt_pkg.so
mv apt_inst.cpython-34m-x86_64-linux-gnu.so apt_inst.so
```

## Installation Docker

Anleitung: https://docs.docker.com/engine/install/ubuntu/

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

Berechtigungen für Docker anpassen

```
$ sudo groupadd docker
$ sudo usermod -aG docker $USER
```

Docker Restart bei Boot/Reboot

```
$ sudo systemctl enable docker
```

## Ansible Playbook

```
$ ansible-playbook playbook.yml
```

```
$ docker exec -it jenkins_prod ls -lrt /var/jenkins_home
```

### Konfig Dateien in das Volume kopieren


### Jenkins Groovy Config

https://github.com/lean-delivery/ansible-role-jenkins