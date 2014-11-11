Vagrant.configure("2") do |config|
	config.vm.box = "trusty64"
	config.vm.box_url = "https://cloud-images.ubuntu.com/vagrant/trusty/current/trusty-server-cloudimg-amd64-vagrant-disk1.box"
	if Vagrant.has_plugin?("vagrant-cachier")
		config.cache.scope = :box
	end

	config.vm.define "web" do |web|
		web.vm.provision "chef_solo", run_list: ["java"]
		web.vm.network "forwarded_port", guest: 8080, host: 8080
		web.vm.network "forwarded_port", guest: 5432, host: 5432
		web.vm.provider "virtualbox" do |v|
			v.name = "web"
			v.memory = 1536
			v.cpus = 4
		end
	end

end
