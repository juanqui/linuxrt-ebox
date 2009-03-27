DESCRIPTION = "r6040"
HOMEPAGE = "http://www.vortex86dx.com/"
SECTION = "kernel/modules"

PR="r0"

SRC_URI = "http://linuxrt-ebox.org/downloads/r6040.tar.gz;md5sum=a37c9302b4384fc336fb68dbcf58a4c5 \
           http://linuxrt-ebox.org/downloads/patch-r6040-linux-2.6.bz2;patch=1;md5sum=01b835a7a00dbe0daa3e4e7b6801e379"

S = "${WORKDIR}/r6040"

inherit module

do_compile() {
	oe_runmake 'KDIR=${STAGING_KERNEL_DIR}'
}

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/
	install -m 0644 r6040${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/
}
