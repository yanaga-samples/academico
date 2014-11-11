execute 'apt-get update'
package 'python-software-properties'
execute 'sudo add-apt-repository ppa:webupd8team/java'
execute 'apt-get update'
execute 'sudo echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections'
package 'oracle-java8-installer'
package 'oracle-java8-set-default'
package 'maven'
package 'git'
package 'tomcat7'
directory '/home/vagrant/.m2' do
  owner 'vagrant'
  group 'vagrant'
  mode 0755
  action :create
end
cookbook_file '/home/vagrant/.m2/settings.xml' do
  owner 'vagrant'
  group 'vagrant'
  action :create
end
