require linux.inc

PR = "r8"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "1"
DEFAULT_PREFERENCE_boc01 = "1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"
DEFAULT_PREFERENCE_canyonlands = "1"
DEFAULT_PREFERENCE_vortex86dx = "1"
DEFAULT_PREFERENCE_ebox3300 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.26.tar.bz2 \
	   ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-2.6.26.8.bz2;patch=1 \
           file://defconfig"

SRC_URI_append_vortex86dx = "\
	${KERNELORG_MIRROR}/pub/linux/kernel/projects/rt/patch-2.6.26.8-rt16.bz2;patch=1 \
	"

SRC_URI_append_ebox3300 = "\
	${KERNELORG_MIRROR}/pub/linux/kernel/projects/rt/patch-2.6.26.8-rt16.bz2;patch=1 \
	"

SRC_URI_append_boc01 = "\
	file://boc01.dts \
	file://fsl-elbc-nand-backport.patch;patch=1 \
	file://002-081105-headers.patch;patch=1 \
	file://004-081105-usb.patch;patch=1 \
	file://005-081217-isl12024.patch;patch=1 \
	file://006-081216-at24c32.patch;patch=1 \
	file://007-081216-lm73.patch;patch=1 \
	file://008-081127-spi.patch;patch=1 \
	file://010-081105-mii.patch;patch=1 \
	file://011-081202-gpio.patch;patch=1 \
	file://012-081222-cy3218-btns.patch;patch=1 \
	file://013-081212-lcd.patch;patch=1 \
	"

SRC_URI_append_mpc8313e-rdb = "\
	file://cdc-ether-hack.patch;patch=1 \
	file://fsl-elbc-nand-backport.patch;patch=1 \
	file://mpc8313e-rdb-leds.patch;patch=1 \
	file://mpc8313e-rdb-cardbus.patch;patch=1 \
	file://mpc8313e-rdb-eth-fixed.patch;patch=1 \
	"

# see http://bugzilla.kernel.org/show_bug.cgi?id=11143
do_stage_append() {
	if [ -f arch/${ARCH}/lib/crtsavres.o ]; then
		mkdir -p ${STAGING_KERNEL_DIR}/arch/${ARCH}/lib
		cp -a arch/${ARCH}/lib/crtsavres.o ${STAGING_KERNEL_DIR}/arch/${ARCH}/lib/
	fi
}

