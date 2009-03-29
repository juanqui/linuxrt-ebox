DESCRIPTION = "vt6655"
HOMEPAGE = "http://www.via.com.tw/en/products/networking/wireless/vt6655/"
SECTION = "kernel/modules"

PR="r0"

SRC_URI = "http://linuxrt-ebox.org/downloads/vt6655.tar.bz2;md5sum=cf12411473b56d7c63903e911acf2024"

S = "${WORKDIR}/vt6655"

inherit module

do_compile() {
	oe_runmake 'KDIR=${STAGING_KERNEL_DIR}'
}

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/
	install -m 0644 driver/viawget${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/
}
