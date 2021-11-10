DESCRIPTION = "Compile Elastic metricbeat."

require elastic-beats.inc

GO_PACKAGE = "metricbeat"

SRC_URI:append = " file://system.yml"

do_install:append() {
    install -d ${D}${sysconfdir}/${GO_PACKAGE}/modules.d
    install -m 0755 ${WORKDIR}/system.yml ${D}${sysconfdir}/${GO_PACKAGE}/modules.d/system.yml
}

