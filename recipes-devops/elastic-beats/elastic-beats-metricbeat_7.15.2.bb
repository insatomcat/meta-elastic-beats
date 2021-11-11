DESCRIPTION = "Compile Elastic metricbeat."

require elastic-beats.inc

inherit systemd
SYSTEMD_AUTO_ENABLE = "enable"

GO_PACKAGE = "metricbeat"

SRC_URI:append = " file://system.yml"
SRC_URI:append = " file://metricbeat.service"
SYSTEMD_SERVICE:${PN} = "metricbeat.service"

FILES:${PN} += "${systemd_system_unitdir}/metricbeat.service"

do_install:append() {
    install -d ${D}${sysconfdir}/${GO_PACKAGE}/modules.d
    install -m 0644 ${WORKDIR}/system.yml ${D}${sysconfdir}/${GO_PACKAGE}/modules.d/system.yml
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/metricbeat.service ${D}${systemd_system_unitdir}
}
