SUMMARY = "NanoPC-T4 kernel"
DESCRIPTION = "FriendlyElec NanoPC-T4 machine kernel"

FILESEXTRAPATHS_prepend := "${THISDIR}/files/4.4.194:"

LINUX_VERSION = "4.4.194"

SRC_URI = " \
    git://github.com/rockchip-linux/kernel.git;branch=develop-4.4 \
    file://adjust_wireless_firmware_path.patch \
"
SRCREV = "${AUTOREV}"

require recipes-kernel/linux/linux-yocto.inc

PV = "${LINUX_VERSION}+git${SRCPV}"

S = "${WORKDIR}/git"

KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "(nanopc-t4|lec-px30)"

SRC_URI += " \
        file://lec-px30_config \
        file://0001-Device-tree-for-LEC-PX30-A2.patch \
        file://0002-Added-ethernet-driver-support-for-LEC-PX30-A2.patch \
        file://0003-Added-mcp25xxfd-driver-support-for-LEC-PX30-A2.patch \
        file://0004-Added-LT9611-driver-support-for-LEC-PX30-A2.patch \
        file://0005-Modified-compatible-property-as-per-target-kernel-dt.patch \
        file://0006-Added-Sx150x-gpio-expander-suppport-for-LEC-PX30-A2.patch \
        file://0007-Added-SPI-chip-select-enable-disable-support-for-SPI.patch \
"

# Comment the below line to mount file system from eMMC
# SRC_URI += "file://0008-Modified-Boot-Arguments-to-mount-fileystem-from-SD-c.patch"
